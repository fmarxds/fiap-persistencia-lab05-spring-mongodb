package br.com.fiap.repository;

import br.com.fiap.entity.Pessoa;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

    //MAPEAMENTO DE FUNÇÕES QUE O MONGO REPOSITORY JÁ TEM COMO PADRÃO

//	List saveAll(List pessoas);
//
//	List findAll();
//
//	List findAll(Sort sort);
//
//	Optional findById(String id);
//
//	Pessoa insert(Pessoa pessoa);
//
//	List insert(List pessoas);
//
//	List findAll(Example example);
//
//    List findAll(Example example, Sort sort);
//
//	void delete(Pessoa pessoa);
//
//	void deleteById(String id);
//
//	void deleteAll(List pessoas);


    List<Pessoa> findByNome(String nome);

    List<Pessoa> findByNomeLike(String nome);

    @Query("{ 'idade' : ?0 }")
    List<Pessoa> findByIdade(int idade);

    @Query("{ 'idade' : { $gt: ?0, $lt: ?1 } }")
    List<Pessoa> findByIdadeBetween(int min, int max);

    @Query("{ 'nome' : { $regex: ?0 } }")
    List<Pessoa> findByRegexpNome(String regexp);

    // 1: crescente, -1: descrescente
    @Query(value = "{ 'nome': { $regex: ?0 } }", sort = "{ 'idade': 1 }")
    List<Pessoa> findByRegexpNomeOrderByIdade(String nome);

    @Query(value = "{ 'nome': ?0 }", count = true)
    int countByName(String nome);

    @Query(value = "{ }", count = true)
    int countAll(String nome);

    @Query("{ 'endereco.cidade' : '?0' }")
    List<Pessoa> findByCidade(String cidade);

}
