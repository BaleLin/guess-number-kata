package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }
    @Test
    public void should_call_a_successful_message_given_a_validate_date(){
        //given
        try{
            actualAnswer.validate();
        }catch (AnswerFormatIncorrectException exception){
            exception.printStackTrace();
        }
    }
    public void should_call_a_fail_message_given_a_unvalidate_date(){
        //given
        actualAnswer = Answer.createAnswer("3 2 3 4");
        //when
        try{
            actualAnswer.validate();
            fail("should fial,but not");
        }catch (AnswerFormatIncorrectException exception){

        }
    }
    public void should_call_success_message_given_a_sameIndex_date(){
        //given
        actualAnswer = Answer.createAnswer("3 2 3 4");
        //when
        try{
            actualAnswer.validate();
            fail("should fial,but not");
        }catch (AnswerFormatIncorrectException exception){

        }
    }
}