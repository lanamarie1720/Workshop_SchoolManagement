package se.lexicon.sequencers;

public class StudentSequencer {

    private static int currentid;

    public static int nextId(){
        return ++currentid;
    }

    public static int getCurrentId(){
        return currentid;
    }

    public static void setCurrentId(int currentId){
        StudentSequencer.currentid = currentId;
    }
}
