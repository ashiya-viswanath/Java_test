package assignment6;
public class Main{
public static void main(String[] args) {

        VoteList christmasPartyVoting =new VoteList();
        Vote []friendVotes = {Vote.YES,Vote.YES, Vote.NO, Vote.INVALID, Vote.INVALID, Vote.NO, Vote.YES,Vote.NO};
        Vote []  familyVotes = {Vote.INVALID, Vote.YES, Vote.YES, Vote.NO};


        System.out.println(christmasPartyVoting.importVotes(friendVotes));

        System.out.println(christmasPartyVoting.isValid());
        System.out.println( christmasPartyVoting.countVotes());

        System.out.println(christmasPartyVoting.importVotes(familyVotes));

        System.out.println(christmasPartyVoting.isValid());
        System.out.println( christmasPartyVoting.countVotes());


        }
}