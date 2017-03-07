package com.dirigendo.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the main activity class for the Quiz App!
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method checks the user answers and displays a toast with the results
     *
     * @param view from where this method is invoked
     */
    public void checkMyAnswers(View view) {
        int result = 0;

        // Check answer #01 and increments result according to result
        if (isAnswer01Right()) {
            result = result + 1;
        }

        // Check answer #02 and increments result according to result
        if (isAnswer02Right()) {
            result = result + 1;
        }

        // Check answer #03 and increments result according to result
        if (isAnswer03Right()) {
            result = result + 1;
        }

        // Check answer #04 and increments result according to result
        if (isAnswer04Right()) {
            result = result + 1;
        }

        // Check answer #05 and increments result according to result
        if (isAnswer05Right()) {
            result = result + 1;
        }

        // Shows user result's as a toast
        Toast.makeText(this, getString(R.string.results_message, result), Toast.LENGTH_SHORT).show();
    }

    /**
     * This method checks answer #01
     *
     * @return true if answer #01 is correct
     */
    private boolean isAnswer01Right() {
        // Retrieve expected answers
        boolean expectedAnswerOptionA =
                Boolean.parseBoolean(getString(R.string.answer_01_option_A_isValid));

        boolean expectedAnswerOptionB =
                Boolean.parseBoolean(getString(R.string.answer_01_option_B_isValid));


        // Figure out which options has the user selected
        RadioButton selectedOptionA = (RadioButton) findViewById(R.id.answer_01_option_A_radio_button);
        RadioButton selectedOptionB = (RadioButton) findViewById(R.id.answer_01_option_B_radio_button);

        // Compare expected answers with user answers
        return (selectedOptionA.isChecked() == expectedAnswerOptionA &&
                selectedOptionB.isChecked() == expectedAnswerOptionB);
    }

    /**
     * This method checks answer #02
     *
     * @return true if answer #02 is correct
     */
    private boolean isAnswer02Right() {
        return checkTextAnswer(R.string.answer_02, R.id.answer_02_edit_text);

    }

    /**
     * This method checks answer #03
     *
     * @return true if answer #03 is correct
     */
    private boolean isAnswer03Right() {
// Retrieve expected answers
        boolean expectedAnswerOptionA =
                Boolean.parseBoolean(getString(R.string.answer_03_option_A_isValid));

        boolean expectedAnswerOptionB =
                Boolean.parseBoolean(getString(R.string.answer_03_option_B_isValid));

        boolean expectedAnswerOptionC =
                Boolean.parseBoolean(getString(R.string.answer_03_option_C_isValid));


        // Figure out which options has the user selected
        CheckBox selectedOptionA = (CheckBox) findViewById(R.id.answer_03_option_A_check_box);
        CheckBox selectedOptionB = (CheckBox) findViewById(R.id.answer_03_option_B_check_box);
        CheckBox selectedOptionC = (CheckBox) findViewById(R.id.answer_03_option_C_check_box);

        // Compare expected answers with user answers
        return (selectedOptionA.isChecked() == expectedAnswerOptionA &&
                selectedOptionB.isChecked() == expectedAnswerOptionB &&
                selectedOptionC.isChecked() == expectedAnswerOptionC);
    }

    /**
     * This method checks answer #04
     *
     * @return true if answer #04 is correct
     */
    private boolean isAnswer04Right() {
        return checkTextAnswer(R.string.answer_04, R.id.answer_04_edit_text);
    }

    /**
     * This method checks answer #05
     *
     * @return true if answer #05 is correct
     */
    private boolean isAnswer05Right() {
        return checkTextAnswer(R.string.answer_05, R.id.answer_05_edit_text);
    }

    /**
     * This method checks an expected answer with a TextView content
     * @param answerId  Id of the expected answer
     * @param editTextId Id of the TextView containing the answer
     *
     * @return true if both answers are equal
     */
    private boolean checkTextAnswer(int answerId, int editTextId) {
        // Retrieve expected answer
        String expectedAnswer = getString(answerId);

        // Retrieve user answer
        String userAnswer = ((TextView) findViewById(editTextId)).getText().toString();

        // Compare user answer with expected answers (within uppercase and removing extra spaces)
        return expectedAnswer.trim().toUpperCase().equals(userAnswer.trim().toUpperCase());
    }
}
