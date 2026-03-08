package com.Group1;

class UserWord {
    String word;
    int score;

    // Constructor for this class
    UserWord(String word, int score){
        this.word = word;
        this.score = score;

    }
    void setWord(String word){
        this.word = word;
    }
    void setScore(int score){
        this.score = score;
    }
    String getWord(){
        return this.word;
    }
    int getScore(){
        return this.score;
    }

}
