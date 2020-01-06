# RoosterTimer

An Android app, written in Java.  It is made for the Udemy course, The Complete Android N Developer Course by Rob Percival.
The goal is to make a countdown timer.

## What I learned

* Developed a UI within the activity_main.xml using RelativeLayout, SeekBar, ImageView, Button and Textview.
* Implemented functionality to the UI using: onCreate, btnPressed, updateTimer and reseTimer.
* Integrated setOnSeekBarChangeListener, so I could initialize the timerSeekBar and get any changes on it.
* Used the CountDownTimer for starting the counting down, when the button is pressed. Also, it handles the changes for every second.
  When it is finished, a MediaPlayer object is initialized for the rooster sound
