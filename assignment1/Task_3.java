package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task_3 {

    public static void main(String[] args) {
        try {
            // Input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the amount in your source currency: ");
            double amount = Double.parseDouble(reader.readLine());

            System.out.print("Enter the source currency code (e.g., USD): ");
            String sourceCurrency = reader.readLine().toUpperCase();

            System.out.print("Enter the target currency code (e.g., EUR): ");
            String targetCurrency = reader.readLine().toUpperCase();

            // Fetch exchange rates
            String exchangeRateApiUrl = "https://api.apilayer.com/exchangerates_data/latest?base=" + sourceCurrency;
            String apiKey = "YOUR_API_KEY";  // Replace with your actual API key
            URL url = new URL(exchangeRateApiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request headers
            connection.setRequestProperty("apikey", apiKey);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON response
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonResponse = (JSONObject) jsonParser.parse(response.toString());
                JSONObject rates = (JSONObject) jsonResponse.get("rates");
                
                if (rates.containsKey(targetCurrency)) {
                    double exchangeRate = (double) rates.get(targetCurrency);

                    // Calculate the converted amount
                    double convertedAmount = amount * exchangeRate;

                    System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
                } else {
                    System.out.println("Target currency (" + targetCurrency + ") not found in the exchange rate data.");
                }
            } else {
                System.out.println("Failed to fetch exchange rates. Response code: " + responseCode);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
