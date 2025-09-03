import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
public class VotingSystemApp {
	public static ArrayList<String> candidateName = new  ArrayList<>();
	public static ArrayList<String> candidateParty = new ArrayList<>();
	public static ArrayList<String> VoterName = new  ArrayList<>();
	public static ArrayList<Integer> candidateVotes = new ArrayList<>();

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		LocalDate date = LocalDate.now();
		int option;
		int option2;
		int votersAge = 0;
		String nameOfCandidate = "";
		String partyOfCandidate = ""; 
		String party = "";
		String nameOfVoter = "";
		String candidate = "";
		System.out.println("---WELCOME---\n");
		do {
			System.out.println("Date: " + date);
			System.out.println("1. Candidate Registration\n");
			System.out.println("2. Voter Registration\n");
			System.out.println("3. Voting Process\n");
			System.out.println("4. Vote Counting\n");
			System.out.println("5. Election Result\n");
			System.out.println("6. Exit\n");
			System.out.print("Select option 1 to get started: ");
			option = input.nextInt();
			input.nextLine();
			
			switch (option) {
				case 1:
					System.out.println("Enter candidate to register: ");
					nameOfCandidate = input.nextLine();
					System.out.println("Enter candidate party: ");
					partyOfCandidate = input.nextLine();
					candidateName.add(nameOfCandidate); 
					candidateParty.add(partyOfCandidate); 
					System.out.println(nameOfCandidate + " of " + partyOfCandidate + " has been registered successfully");
					System.out.println(); break;
					
				case 2:
					System.out.print("Enter name of voter: ");
                    		nameOfVoter = input.nextLine();
                    		System.out.print("Enter voter's age (must be 18 or older): ");
                    		votersAge = input.nextInt();
                    		input.nextLine();
                    			if (votersAge >= 18){
                    				if (!VoterName.contains(nameOfVoter)){
                    					VoterName.add(nameOfVoter);
                    					System.out.println(nameOfVoter + " has been registered successfully\n");
                    				} else {
                    					System.out.println(nameOfVoter + " has already been registered\n");	
                    					}
                    			      }
                    				else {
                    					System.out.println("Must be 18 or older to register\n");
                    			}
                    				break;
                    	case 3:
					if (candidateName.isEmpty()){
						System.out.println("No candidates registered yet");
					}
					if (VoterName.isEmpty()){
						System.out.println("No voters registered yet\n");
						break;
					}	
					
					System.out.println("Show Registered Candidates: ");
					showCandidatesAndParty();	
					System.out.println();
					System.out.println("Enter your name: ");
					String voter = input.nextLine();
						if (!VoterName.contains(voter)){
							System.out.println("Voter is not registered");
							break;
						}
					System.out.println("Enter candidate to vote for: ");
					String choiceOfCandidate = input.nextLine();
						if (candidateName.contains(choiceOfCandidate)){
							System.out.println(choiceOfCandidate + " has been voted for successfully");
						} else {
							System.out.println("Candidate does not exist or is not registered");
						} break;
				case 4:
					System.out.println("Current vote counts:");
						for (int voteCount = 0; voteCount < candidateName.size(); voteCount++){
							System.out.println(candidateName.get(voteCount) + " - " + candidateVotes.get(voteCount) + " votes");
						}
					System.out.println(); break;
				case 5:
					if (candidateVotes.isEmpty()){
						System.out.println("No votes cast yet\n");
						break;
					}	
					String winner = null;
					int maxVotes = -1;
					for (int vote = 0; vote < candidateName.size(); vote++){
						if (candidateVotes.get(vote) > maxVotes){
							maxVotes = candidateVotes.get(vote);
							winner = candidateName.get(vote); 
						}
					}	
					System.out.println("Election Winner: " + winner + " with " + maxVotes + " votes!\n");
					break;			
			}
		
		}
		while (option != 6);
		input.close();	
	}
	
	public static void showCandidatesAndParty(){
		for (int candidateAndParty = 0; candidateAndParty < candidateName.size(); candidateAndParty++){
			System.out.println("Candidate " + (candidateAndParty + 1) + ": " + candidateName.get(candidateAndParty) + " - " + candidateParty.get(candidateAndParty));
		}
	}
		
	public static void castRegisteredVotersVote(String castVote) {
        int index = candidateName.indexOf(castVote);
        if (index != -1) {
            candidateVotes.set(index, candidateVotes.get(index) + 1);
        }
    }
	
}