package com.razon.course15;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.InputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    InputStream myInputStream;
    POIFSFileSystem myFileSystem;
    HSSFWorkbook myWorkBook;
    HSSFSheet myQuestionSheet, myAnswerSheet, myRationaleSheet;
    TextView questionTextBoxToChange, answerATextBoxToChange, answerBTextBoxToChange, answerCTextBoxToChange, answerDTextBoxToChange;
    Random randomGenerator;
    Boolean answerShown;
    int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        InitializeItems();
        LoadFile();
        Update();
    }

    public void InitializeItems() {
        randomGenerator = new Random();
        questionNumber = randomGenerator.nextInt(22);
        answerShown = false;
        questionTextBoxToChange = (TextView) findViewById(R.id.questionTextBox);
        answerATextBoxToChange = (TextView) findViewById(R.id.answerATextBox);
        answerBTextBoxToChange = (TextView) findViewById(R.id.answerBTextBox);
        answerCTextBoxToChange = (TextView) findViewById(R.id.answerCTextBox);
        answerDTextBoxToChange = (TextView) findViewById(R.id.answerDTextBox);
    }

    public void LoadFile() {
        try {
            myInputStream = getAssets().open("course15setb.xls");
            myFileSystem = new POIFSFileSystem(myInputStream);
            myWorkBook = new HSSFWorkbook(myFileSystem);
            myQuestionSheet = myWorkBook.getSheetAt(0);
            myAnswerSheet = myWorkBook.getSheetAt(1);
            myRationaleSheet = myWorkBook.getSheetAt(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        questionTextBoxToChange.setText(myQuestionSheet.getRow(questionNumber).getCell(0).getStringCellValue());
        answerATextBoxToChange.setText(myAnswerSheet.getRow(questionNumber).getCell(0).getStringCellValue());
        answerBTextBoxToChange.setText(myAnswerSheet.getRow(questionNumber).getCell(1).getStringCellValue());
        answerCTextBoxToChange.setText(myAnswerSheet.getRow(questionNumber).getCell(2).getStringCellValue());
        answerDTextBoxToChange.setText(myAnswerSheet.getRow(questionNumber).getCell(3).getStringCellValue());
        answerShown = false;
    }

    public void ShowAnswer() {
        questionTextBoxToChange.setText(myQuestionSheet.getRow(questionNumber).getCell(0).getStringCellValue());
        answerATextBoxToChange.setText(myRationaleSheet.getRow(questionNumber).getCell(0).getStringCellValue());
        answerBTextBoxToChange.setText(myRationaleSheet.getRow(questionNumber).getCell(1).getStringCellValue());
        answerCTextBoxToChange.setText(myRationaleSheet.getRow(questionNumber).getCell(2).getStringCellValue());
        answerDTextBoxToChange.setText(myRationaleSheet.getRow(questionNumber).getCell(3).getStringCellValue());
        questionNumber = randomGenerator.nextInt(22);
        answerShown = true;
    }

    public int RandomizeTheNumber() {
        return randomGenerator.nextInt(22);
    }

    public void answerAClicked(View view) {
        if (answerShown == false) {
            ShowAnswer();
        } else {
            Update();
        }
    }

    public void answerBClicked(View view) {
        if (answerShown == false) {
            ShowAnswer();
        } else {
            Update();
        }
    }

    public void answerCClicked(View view) {
        if (answerShown == false) {
            ShowAnswer();
        } else {
            Update();
        }
    }

    public void answerDClicked(View view) {
        if (answerShown == false) {
            ShowAnswer();
        } else {
            Update();
        }
    }
}