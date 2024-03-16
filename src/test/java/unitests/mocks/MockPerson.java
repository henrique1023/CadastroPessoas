package unitests.mocks;

import com.cadastro.pessoas.cadastropessoas.model.Pessoa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockPerson {

    public Pessoa mockEntity() {
        return mockEntity(0);
    }

    public List<Pessoa> mockEntityList() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            pessoas.add(mockEntity(i));
        }
        return pessoas;
    }

    public Pessoa mockEntity(Integer number) {
        Pessoa pessoas = new Pessoa();
        pessoas.setNome("Primeiro nome " + number);
        pessoas.setIdade(new Date());
        pessoas.setSexo(((number % 2)==0) ? "Ma" : "Fe");
        return pessoas;
    }
}
