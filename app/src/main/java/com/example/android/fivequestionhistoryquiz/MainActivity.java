package com.example.android.fivequestionhistoryquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private CheckBox qTwoAnswerA;
    private CheckBox qTwoAnswerB;
    private CheckBox qTwoAnswerC;
    private CheckBox qTwoAnswerD;
    private EditText editTextIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup1.clearCheck();

        radioGroup3 = findViewById(R.id.radioGroup3);
        radioGroup3.clearCheck();

        radioGroup4 = findViewById(R.id.radioGroup4);
        radioGroup4.clearCheck();

        qTwoAnswerA = findViewById(R.id.qTwoAnswerA);
        qTwoAnswerB = findViewById(R.id.qTwoAnswerB);
        qTwoAnswerC = findViewById(R.id.qTwoAnswerC);
        qTwoAnswerD = findViewById(R.id.qTwoAnswerD);

        editTextIn = findViewById(R.id.questionFiveInput);

    }

    public void clearAnswers5(View v) {
        /*Clears All Selected radio Buttons, check boxes and text input to Default */
        radioGroup1.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();

        editTextIn.getText().clear();

        if (qTwoAnswerA.isChecked()) {
            qTwoAnswerA.setChecked(false);
        }
        if (qTwoAnswerB.isChecked()) {
            qTwoAnswerB.setChecked(false);
        }
        if (qTwoAnswerC.isChecked()) {
            qTwoAnswerC.setChecked(false);
        }
        if (qTwoAnswerD.isChecked()) {
            qTwoAnswerD.setChecked(false);
        }
    }

    public void submitAnswers5(View v) {
        /*Variables for output and score tracking*/
        int totalScore = 0;
        String completeScore = "Your Score Results are: ";

        /*Inputs for checkboxes and EditText*/
        boolean isCheckedA = qTwoAnswerA.isChecked();
        boolean isCheckedB = qTwoAnswerB.isChecked();
        boolean isCheckedC = qTwoAnswerC.isChecked();
        boolean isCheckedD = qTwoAnswerD.isChecked();

        /*Question #1 Logic Block*/
        int rbCheck1 = radioGroup1.getCheckedRadioButtonId();
        RadioButton rbq1a1 = findViewById(R.id.qOneAnswerA);
        RadioButton rbq1a2 = findViewById(R.id.qOneAnswerB);
        RadioButton rbq1a3 = findViewById(R.id.qOneAnswerC);
        RadioButton rbq1a4 = findViewById(R.id.qOneAnswerD);

        if (rbCheck1 != 0) {
            if (rbq1a1.isChecked()) {
                completeScore = completeScore + "\nQuestion #1 is correct, +1 Point!";
                totalScore += 1;
            } else if (rbq1a2.isChecked() || rbq1a3.isChecked() || rbq1a4.isChecked()) {
                completeScore = completeScore + "\nQuestion #1 is incorrect";
                completeScore = completeScore + "\n -- The Correct Answer is George Washignton";
            } else {
                Toast.makeText(MainActivity.this, "Please make a Selection for Question #1", Toast.LENGTH_SHORT).show();
            }
        }

        /*Question #2 Logic Block*/
        if (!isCheckedA && !isCheckedB && !isCheckedC && !isCheckedD) {
            Toast.makeText(MainActivity.this, "Please make a Selection for Question #2", Toast.LENGTH_SHORT).show();
        } else if (isCheckedA && !isCheckedB && isCheckedC && !isCheckedD) {
            completeScore = completeScore + "\nQuestion #2 is correct, +1 Point!";
            totalScore += 1;
        } else {
            completeScore = completeScore + "\nQuestion #2 is incorrect";
            completeScore = completeScore + "\n -- The Correct Answer is Valentina Tereshkova and Sally Ride";
        }

        /*Question #3 Logic Block*/
        int rbCheck3 = radioGroup3.getCheckedRadioButtonId();
        RadioButton rbq3a4 = findViewById(R.id.qThreeAnswerD);
        RadioButton rbq3a1 = findViewById(R.id.qThreeAnswerA);
        RadioButton rbq3a2 = findViewById(R.id.qThreeAnswerB);
        RadioButton rbq3a3 = findViewById(R.id.qThreeAnswerC);

        if (rbCheck3 != 0) {
            if (rbq3a4.isChecked()) {
                completeScore = completeScore + "\nQuestion #3 is correct, +1 Point!";
                totalScore += 1;
            } else if (rbq3a1.isChecked() || rbq3a2.isChecked() || rbq3a3.isChecked()) {
                completeScore = completeScore + "\nQuestion #3 is incorrect";
                completeScore = completeScore + "\n -- The Correct Answer is Sun Microsystems";
            } else {
                Toast.makeText(MainActivity.this, "Please make a Selection for Question #3", Toast.LENGTH_SHORT).show();
            }
        }

        /*Question #4 Logic Block*/
        int rbCheck4 = radioGroup4.getCheckedRadioButtonId();
        RadioButton rbq4a1 = findViewById(R.id.qFourAnswerA);
        RadioButton rbq4a2 = findViewById(R.id.qFourAnswerB);
        RadioButton rbq4a3 = findViewById(R.id.qFourAnswerC);
        RadioButton rbq4a4 = findViewById(R.id.qFourAnswerD);

        if (rbCheck4 != 0) {
            if (rbq4a1.isChecked()) {
                completeScore = completeScore + "\nQuestion #4 is correct, +1 Point!";
                totalScore += 1;
            } else if (rbq4a2.isChecked() || rbq4a3.isChecked() || rbq4a4.isChecked()) {
                completeScore = completeScore + "\nQuestion #4 is incorrect";
                completeScore = completeScore + "\n -- The Correct Answer is Login";
            } else {
                Toast.makeText(MainActivity.this, "Please make a Selection for Question #4", Toast.LENGTH_SHORT).show();
            }
        }


        /*Question #5 Logic Block*/
        String questionFiveInput = editTextIn.getText().toString();
        if (!questionFiveInput.equalsIgnoreCase("")) {

            if (questionFiveInput.equalsIgnoreCase("2008")) {
                completeScore = completeScore + "\nQuestion #5 is correct, +1 Point!";
                totalScore += 1;
            } else {
                completeScore = completeScore + "\nQuestion #5 is incorrect";
                completeScore = completeScore + "\n -- The Correct Answer is 2008";
            }

        } else {
            Toast.makeText(MainActivity.this, "Please make a Selection for Question #5", Toast.LENGTH_SHORT).show();
        }
        /*Final output Logic Block*/
        completeScore = completeScore + "\nYour total score is: " + totalScore;
        Toast.makeText(MainActivity.this, completeScore, Toast.LENGTH_LONG).show();
    }
}



