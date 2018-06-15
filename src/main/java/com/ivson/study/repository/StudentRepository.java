package com.ivson.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivson.study.model.Student;

/**
 * JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository interface.
 * 
 * public abstract interface PagingAndSortingRepository extends CrudRepository {  
  		public abstract Iterable findAll(Sort arg0);  
  		public abstract Page findAll(Pageable arg0);
   }
   
   public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
	    <S extends T> S save(S entity);
	    T findOne(ID primaryKey);       
	    Iterable<T> findAll();          
	    Long count();                   
	    void delete(T entity);          
	    boolean exists(ID primaryKey);  
   }
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}
