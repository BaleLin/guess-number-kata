package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import java.lang.reflect.Array;

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
    @Test
    public void should_call_a_fail_message_given_a_unvalidate_date(){
        //given
        actualAnswer = Answer.createAnswer("13 22 3 4");
        //when
        try{
            actualAnswer.validate();
            fail("should fial,but not");
        }catch (AnswerFormatIncorrectException exception){

        }
    }
    @Test
    public void should_call_success_message_given_a_sameIndex_date(){
        //given
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        try{
            inputAnswer.validate();
        }catch (AnswerFormatIncorrectException exception){

        }
        //when
        Record Actualrecord = actualAnswer.check(inputAnswer);
        assertThat(Actualrecord.getValue(), is("4A0B"));
 }
    @Test
    public void should_call_success_given_a_diffent_Index_date(){
        //given
        Answer inputAnswer = Answer.createAnswer("6 3 2 1");
        //when
        Record Actualrecord = actualAnswer.check(inputAnswer);
        assertThat(Actualrecord.getValue(), is("0A3B"));
    }

    @Test
    public void should_return_String_of_newlists_when_toString(){
        Answer answer = Answer.createAnswer("2 1 5 4");
        assertThat(answer.toString(),is("2 1 5 4"));
    }
}