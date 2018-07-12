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
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        try{
            inputAnswer.validate();
        }catch (AnswerFormatIncorrectException exception){

        }
        //when
        Record Actualrecord = actualAnswer.check(inputAnswer);
        int[] exceptionRecordValue = new int[]{4,0};
        assertThat(Actualrecord.getValue(), is(exceptionRecordValue));
 }

    public void should_call_success_given_a_diffent_Index_date(){
        //given
        Answer inputAnswer = Answer.createAnswer("4 3 2 1");
        //when
        Record Actualrecord = actualAnswer.check(inputAnswer);
        int[] exceptionRecordValue = new int[]{0,4};
        assertThat(Actualrecord.getValue(), is(exceptionRecordValue));
    }
}