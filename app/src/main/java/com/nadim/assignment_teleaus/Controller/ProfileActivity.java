package com.nadim.assignment_teleaus.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nadim.assignment_teleaus.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout personalinfo, experience, review;
    ImageView backButton;
    CircleImageView profileImageShow;
    TextView personalinfobtn, experiencebtn, reviewbtn,firstNameTxt,lastNameTxt,companyNameTxt,experienceTxt,qualificationTxt,coverLetterTxt,phoneNumberTxt,emailTxt,locationTxt;
    String firstNameShow,lastNameShow,companyName,profilePic,experienceShow,coverLetter,qualification,phoneNumber,email,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initialise();
        personalinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.VISIBLE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.blue));
                experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                reviewbtn.setTextColor(getResources().getColor(R.color.grey));

            }
        });

        experiencebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.GONE);
                experience.setVisibility(View.VISIBLE);
                review.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                experiencebtn.setTextColor(getResources().getColor(R.color.blue));
                reviewbtn.setTextColor(getResources().getColor(R.color.grey));

            }
        });

        reviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.GONE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.VISIBLE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                reviewbtn.setTextColor(getResources().getColor(R.color.blue));

            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initialise() {

        //Get from HomeFragment
        Intent i=getIntent();
        firstNameShow= i.getStringExtra("firstName");
        lastNameShow= i.getStringExtra("lastName");
        companyName= i.getStringExtra("companyName");
        profilePic= i.getStringExtra("profileImageShow");
        experienceShow= i.getStringExtra("experience");
        coverLetter= i.getStringExtra("coverLetter");
        qualification= i.getStringExtra("qualification");
        phoneNumber= i.getStringExtra("phoneNumber");
        email= i.getStringExtra("email");
        location= i.getStringExtra("location");

        //// User Info
        firstNameTxt = findViewById(R.id.firstName);
        lastNameTxt = findViewById(R.id.lastName);
        companyNameTxt = findViewById(R.id.companyName);
        profileImageShow = findViewById(R.id.profileImageShow);
        experienceTxt = findViewById(R.id.experienceTxt);
        coverLetterTxt = findViewById(R.id.coverLetterTxt);
        qualificationTxt = findViewById(R.id.qualificationTxt);
        phoneNumberTxt = findViewById(R.id.phoneNumberTxt);
        emailTxt = findViewById(R.id.emailTxt);
        locationTxt = findViewById(R.id.locationTxt);
        backButton = findViewById(R.id.backButton);
        personalinfo = findViewById(R.id.personalinfo);
        experience = findViewById(R.id.experience);
        review = findViewById(R.id.review);
        personalinfobtn = findViewById(R.id.personalinfobtn);
        experiencebtn = findViewById(R.id.experiencebtn);
        reviewbtn = findViewById(R.id.reviewbtn);

        /*making personal info visible*/
        personalinfo.setVisibility(View.VISIBLE);
        experience.setVisibility(View.GONE);
        review.setVisibility(View.GONE);

        //Set value
        firstNameTxt.setText(firstNameShow);
        lastNameTxt.setText(lastNameShow);
        companyNameTxt.setText(companyName);
        Glide.with(this).load(profilePic).into(profileImageShow);
        experienceTxt.setText(experienceShow);
        coverLetterTxt.setText(coverLetter);
        qualificationTxt.setText(qualification);
        phoneNumberTxt.setText(phoneNumber);
        emailTxt.setText(email);
        locationTxt.setText(location);
    }
}