package br.com.alura.escola.academico.integration.aluno;

import br.com.alura.escola.academico.domain.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Utilizando JDBC
public class AlunosRepositoryJDBC implements RepositorioDeAlunos {
    private final Connection connection;

    public AlunosRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getCpf().getNumero());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getEmail().getEndereco());
            preparedStatement.execute();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            for (Telefone telefone : aluno.getTelefones()) {
                preparedStatement.setString(1, telefone.getDdd());
                preparedStatement.setString(2, telefone.getNumero());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) throws AlunoNaoEncontrado {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getNumero());

            // utilizado para select/consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean encontrou = resultSet.next();
            if (!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }
            String nome = resultSet.getString("nome");
            Email email = new Email(resultSet.getString("email"));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = resultSet.getLong("id");
            sql ="SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String ddd = resultSet.getString("ddd");
                encontrado.adicionarTelefone(ddd, numero);
            }
            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNO";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while (resultSet.next()) {
                CPF cpf = new CPF(resultSet.getString("cpf"));
                String nome = resultSet.getString("nome");

                Email email = new Email(resultSet.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = resultSet.getLong("id");
                sql ="SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                psTelefone.setLong(1, id);
                ResultSet rsTelefone = preparedStatement.executeQuery();
                while (rsTelefone.next()) {
                    String numero = rsTelefone.getString("numero");
                    String ddd = rsTelefone.getString("ddd");
                    aluno.adicionarTelefone(ddd, numero);
            }
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }

