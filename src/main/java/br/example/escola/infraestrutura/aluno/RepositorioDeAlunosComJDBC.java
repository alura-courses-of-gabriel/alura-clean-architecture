package br.example.escola.infraestrutura.aluno;

import br.example.escola.dominio.aluno.Aluno;
import br.example.escola.dominio.aluno.CPF;
import br.example.escola.dominio.aluno.Email;
import br.example.escola.dominio.aluno.RepositorioDeAlunos;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNO VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getCpf());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getEmail());
            preparedStatement.execute();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            PreparedStatement preparedStatement2 = this.connection.prepareStatement(sql);
            aluno.getTelefones().forEach(telefone -> {
                try {
                    preparedStatement2.setString(1, telefone.getDdd());
                    preparedStatement2.setString(2, telefone.getNumero());
                    preparedStatement2.execute();
                } catch (SQLException e) {
                    throw new RuntimeException();
                }

            });

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Aluno buscarAlunoPorCPF(CPF cpf) {
        String sql = "SELECT ID, NOME, EMAIL FROM ALUNO WHERE CPF=?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getDigitos());

            ResultSet resultSet = preparedStatement.executeQuery();

            boolean encontrou = resultSet.next();
            if (!encontrou) throw new RuntimeException();

            String nome = resultSet.getString("nome");
            Email email = new Email(resultSet.getString("email"));
            CPF cpfEncontrado = new CPF(resultSet.getString("cpf"));
            Aluno aluno = new Aluno(cpfEncontrado, nome, email);

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String numero = resultSet.getString("numero");
                String ddd = resultSet.getString("ddd");
                aluno.adicionarTelefone(ddd, numero);
            }

            return aluno;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return null;
    }
}
