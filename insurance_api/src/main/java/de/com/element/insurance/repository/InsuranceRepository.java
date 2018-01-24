package de.com.element.insurance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;

import de.com.element.insurance.entity.InsuranceEntity;
import de.com.element.insurance.entity.QInsuranceEntity;

	
/**	
 * @author diegosanteri
 *
 */
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, String>, 
												QueryDslPredicateExecutor<InsuranceEntity>, 
												QuerydslBinderCustomizer<QInsuranceEntity> {
	
	  Page<InsuranceEntity> findAll(Specification<InsuranceEntity> spec, Pageable makeRequest);
	  
	  @Override
	    default public void customize(QuerydslBindings bindings, QInsuranceEntity root) {
		  bindings.bind(String.class).first(new SingleValueBinding<StringPath, String>() {
			  
			@Override
			public Predicate bind(StringPath path, String s) {
				return path.equalsIgnoreCase(s);
			}
          });
	    }
}
