/**
 * 
 */
package com.survey.repository.question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey.entity.Question;

/**
 * This is an interface for Question repository to manage CRUD operations to Question table.
 * @author naresh.ravurumckesson.com
 *
 */

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
