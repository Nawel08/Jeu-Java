package univers2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import representation.InnerNode;
import representation.DecisionNode;

public class Evenements_3 {
	
	InnerNode in= new InnerNode();
	DecisionNode dn = new DecisionNode();
	
	public void objectif() {
		in.display("Tu vas devoir jouer à un jeu au cours duquel, le perdant MEURT");
	}
	
	public String choix(String s1, String s2) {
		String choix=dn.choix_2_string(s1,s2);
		return choix;
		
	}
	private static final String API_BASE_URL = "https://api.chess.com/pub/player/";

    public static boolean playChessOnline(String playerName) {
        try {
            String apiUrl = API_BASE_URL + playerName + "/games";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the response JSON and check if the player won
                // This is a simplified example; you may need to adapt it based on the Chess.com API response format
                boolean playerWon = parseChessApiResponse(response.toString());

                if (playerWon) {
                    System.out.println("Congratulations! You won the chess game.");
                } else {
                    System.out.println("Sorry, you lost the chess game.");
                }

                return playerWon;
            } else {
                System.out.println("Failed to connect to Chess.com API. HTTP Error Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean parseChessApiResponse(String jsonResponse) {
        // Implement the logic to parse the Chess.com API response
        // and determine if the player won the game
        // This will depend on the actual response format from the API
        // For simplicity, let's assume the response is a JSON with a "result" field indicating the game result

        // Example JSON response: {"result": "win"}
        // You may need to adjust this based on the actual API response
        return jsonResponse.contains("\"result\": \"win\"");
    }

}
