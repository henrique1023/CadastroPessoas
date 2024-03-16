package unitests.mockito.services;
import static org.junit.jupiter.api.Assertions.*;

import com.cadastro.pessoas.cadastropessoas.model.Pessoa;
import com.cadastro.pessoas.cadastropessoas.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;
import unitests.mocks.MockPerson;

import java.util.List;
import java.util.Objects;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaServicesTest {

    MockPerson input;
    private PessoaService services;

    @BeforeEach
    void setUp() throws Exception {
        input = new MockPerson();
        services = new PessoaService();
    }

    @Test
    void testFindById() throws Exception {
        Pessoa entity = input.mockEntity(1);
        Pessoa objResult = services.saveOrUptade(entity);
        Pessoa result = services.findById(objResult.getId());
        assertNotNull(result);
        assertTrue(result.toString().contains(""));
        assertEquals("Primeiro nome 1" , result.getNome());
        assertEquals("Fe" , result.getSexo());
        assertEquals(entity.getIdade() , result.getIdade());
        services.delete(objResult);
    }

    @Test
    void testCreate() throws Exception {
        Pessoa entity = input.mockEntity(1);
        Pessoa result = services.saveOrUptade(entity);
        assertNotNull(result);
        assertTrue(result.toString().contains(""));
        assertEquals("Primeiro nome 1" , result.getNome());
        assertEquals("Fe" , result.getSexo());
        assertEquals(entity.getIdade() , result.getIdade());
        services.delete(result);
    }
    @Test
    void testUpdate() throws Exception {
        Pessoa entity = input.mockEntity(1);
        Pessoa result = services.saveOrUptade(entity);
        Pessoa objUpdated = services.saveOrUptade(result);
        assertNotNull(objUpdated);
        assertTrue(objUpdated.toString().contains(""));
        assertEquals("Primeiro nome 1" , objUpdated.getNome());
        assertEquals("Fe" , objUpdated.getSexo());
        assertEquals(entity.getIdade() , objUpdated.getIdade());
        services.delete(objUpdated);
    }
    @Test
    void testDelete() throws Exception {
        Pessoa entity = input.mockEntity(1);
        Pessoa result = services.saveOrUptade(entity);
        services.delete(result);
    }
    @Test
    void testFindByAll() {
        Pessoa entity = input.mockEntity(1);
        Pessoa result = services.saveOrUptade(entity);
        List<Pessoa> pessoaList = services.findAll();
        Pessoa pessoaReturno = null;
        for(Pessoa p: pessoaList){
            if(Objects.equals(p.getId(), result.getId()))
                pessoaReturno = p;
        };
        assertNotNull(pessoaReturno);
        assertTrue(pessoaReturno.toString().contains(""));
        assertEquals("Primeiro nome 1" , pessoaReturno.getNome());
        assertEquals("Fe" , pessoaReturno.getSexo());
        assertEquals(entity.getIdade() , pessoaReturno.getIdade());
        services.delete(pessoaReturno);
    }

}
