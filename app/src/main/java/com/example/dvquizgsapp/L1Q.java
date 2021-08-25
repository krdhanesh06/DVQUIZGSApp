package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class L1Q extends AppCompatActivity {
    TextView tv, tvscore;
    TextView dispName, dispMobile;
    Button submitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "1. Who can experience domestic violence?\n घरेलू हिंसा का अनुभव कौन कर सकता है ?",
            "2. If a child hears their parent being abused in another room and then hears it go silent, what are they likely to think?\n यदि कोई बच्चा अपने माता-पिता को दूसरे कमरे में गाली देते हुये सुनता है तो वह चुप हो जाता है, उनके सोचने की संभावना क्या है?",
            "3. Poverty and unemployment are two of the -------\n गरीबी और बेरोजगारी दो हैं -------",
            "4. Which of the following statements is TRUE in regard to primary aggression?\n प्राथमिक आक्रामकता के संबंध में निम्नलिखित में से कौन सा कथन सही है?",
            "5. Violence directed at members of a particular cultural or racial group is known as _______.\n एक विशेष सांस्कृतिक या नस्लीय समूह के सदस्यों पर निर्देशित हिंसा को _______ के रूप में जाना जाता है।",
            "6. In cases of domestic violence in which a woman is the abuser, _______.\n घरेलू हिंसा के मामलों में जिसमें एक महिला नशेड़ी है, _______।",
            "7. One of the main predictors of domestic violence is \n घरेलू हिंसा के मुख्य भविष्यवक्ताओं में से एक है",
            "8. All EXCEPT which of the following are acts of sexual assault?\n निम्नलिखित सभी में से कौन सा यौन उत्पीड़न का कार्य करता है?",
            "9. Which of the following should a rape victim do immediately after the attack?\n एक बलात्कार पीड़िता को हमले के तुरंत बाद क्या करना चाहिए?",
            "10. A primary factor in acquaintance rape is _______.\n परिचित बलात्कार में एक प्राथमिक कारक _______ है।"

    };
    String answers[] = {"Anyone / कोई भी व्यक्ति","That their parent is unhappy or fighting / कि उनके माता-पिता दुःखी या झगड़ा कर रहे है","Societal factors that may lead to violence / सामाजिक कारक जो हिंसा का कारण बन सकते हैं","It is hostile self-assertion that is destructive in nature. / यह शत्रुतापूर्ण आत्म-विश्वास है जो प्रकृति में विनाशकारी है।","Ethnic Violence / जातीय हिंसा","The man is less likely to sustain severe injuries / आदमी को गंभीर चोटों की संभावना कम होती है",
            "Marital Dissatisfaction / वैवाहिक असंतोष","Consensual acts among adults / वयस्कों  के  बीच सहमति  से  काम करना","Call 911 to report the attack. / हमले की सूचना देने के लिए 911 पर कॉल करें।","The use of alcohol and/or drugs / शराब और / या ड्रग्स का उपयोग"};
    String opt[] = {
            "Teenagers / किशोर","Anyone / कोई भी व्यक्ति","Women /  महिलायें","Same-sex couples / समान जाती के लोग",
            "That their parents have come to an agreement / कि उनके माता-पिता एक समझौते पर आए हैं","That it's safe to come out / कि बाहर आना सुरक्षित है","That their parent is happy now / कि उनके माता-पिता अब खुश हैं","That their parent is unhappy or fighting / कि उनके माता-पिता दुःखी या झगड़ा कर रहे है",
            "Personality disorders that may lead to violence / व्यक्तित्व विकार जो हिंसा को जन्म दे सकते हैं","Societal factors that may lead to violence / सामाजिक कारक जो हिंसा का कारण बन सकते हैं","Causes of unintentional injuries / अनजाने में हुई चोटों के कारण","causes of unintentional injuries factors that may lead to discrimination / अनजाने चोटों के कारकों के कारण जो भेदभाव का कारण बन सकते हैं",
            "It results from a person's frustration with life experiences. / यह जीवन के अनुभवों के साथ एक व्यक्ति की हताशा का परिणाम है।","It is hostile self-assertion that is destructive in nature. / यह शत्रुतापूर्ण आत्म-विश्वास है जो प्रकृति में विनाशकारी है।","It is a hereditary condition. / यह एक वंशानुगत स्थिति है।","It will not result in the bodily harm of others. / इससे दूसरों की शारीरिक हानि नहीं होगी।",
            "Ethnic Violence / जातीय हिंसा","Terrorism / आतंक","Regional Violence / क्षेत्रीय हिंसा","Premeditated Violence / पूर्वनिर्धारित हिंसा",
            "The episodes of abuse occur more frequently / दुरुपयोग के एपिसोड अधिक बार होते हैं","The man is less likely to sustain severe injuries / आदमी को गंभीर चोटों की संभावना कम होती है","The man is likely to tell a friend or family member about the abuse / आदमी को दुरुपयोग के बारे में एक दोस्त या परिवार के सदस्य को बताने की संभावना है","The man is likely to end up in the hospital due to severe injuries / गंभीर रूप से घायल होने के कारण आदमी के अस्पताल में समाप्त होने की संभावना है",
            "Personal Bankruptcy / व्यक्तिगत दिवालियापन","Tobacco Use / तंबाकू इस्तेमाल","A Second Marriage / एक दूसरी शादी","Marital Dissatisfaction / वैवाहिक असंतोष",
            "Physical intimacy / शारीरिक अंतरंगता","Consensual acts among adults / वयस्कों  के  बीच सहमति  से  काम करना","Forceful Penetration / बलपूर्वक पेनेट्रेशन","Simple touching / साधारण स्पर्श",
            "Call 911 to report the attack. / हमले की सूचना देने के लिए 911 पर कॉल करें।","Bathe or shower to remove bacteria and prevent infection. / बैक्टीरिया को हटाने और संक्रमण को रोकने के लिए स्नान करें।","Wash or discard the clothing worn during the attack. / हमले के दौरान पहने हुए कपड़ों को धोएं या त्यागें।","Call a friend and go to his or her house. / एक दोस्त को बुलाओ और उसके घर जाओ।",
            "The use of alcohol and/or drugs / शराब और / या ड्रग्स का उपयोग","Previous stalking of the victim before the rape occurs / बलात्कार होने से पहले पीड़ित का पीछा करना","Poor lighting in public areas / सार्वजनिक क्षेत्रों में खराब रोशनी","The victim being in an unfamiliar environment / एक अपरिचित वातावरण में शिकार हो रहा है"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l1_q);
        final TextView score = (TextView)findViewById(R.id.tvscore);
        final TextView textView=(TextView)findViewById(R.id.dispName);

        dispName= (TextView) findViewById(R.id.dispName);
        dispMobile= (TextView) findViewById(R.id.dispMobile);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        dispName.setText(name);
        dispName.setTextColor(Color.BLUE);
        dispName.setText(""+ name);
        String mobile = intent.getStringExtra("mobile");
        dispMobile.setText(mobile);
        dispMobile.setTextColor(Color.BLUE);
        dispMobile.setText(""+ mobile);

        tvscore = (TextView)findViewById(R.id.tvscore);
        submitbutton=(Button)findViewById(R.id.submitbutton);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton1);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);

        tv.setText(questions[flag]);

        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("Your score is : "+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    String name = dispName.getText().toString();
                    String mobile = dispMobile.getText().toString();
                    Intent ing = new Intent(getApplicationContext(),L1R.class);

                    ing.putExtra("name", name);
                    ing.putExtra("mobile", mobile);
                    startActivity(ing);
                }
                radio_g.clearCheck();

            }
        });
    }

}