import java.util.Arrays;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemperatures = new float[patientsCount];


        for (int i = 0; i < patientsCount; i++) {
            float randomNum = (float) (32 + (Math.random() * 8));
            patientsTemperatures[i] = randomNum;

        }
        return patientsTemperatures;
    }

    public static int getHealthyPatients(float[] temperatureData) {
        int numberOfHealthyGuys = 0;
        for (float temperatureDatum : temperatureData) {
            if (temperatureDatum <= 36.9F && temperatureDatum >= 36.2F) {
                numberOfHealthyGuys++;
            }
        }
        return numberOfHealthyGuys;
    }

    public static String getAverageTemperature(float[] temperatureData) {

        float sum = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            sum += temperatureData[i];
        }
        float averageTemperature = sum / temperatureData.length;
        String result = String.format("%.2f", averageTemperature);

        return result;
    }


    public static String getReport(float[] temperatureData) {
        String regex = "[^0-9.]+";
        String result = "";
        for (int i = 0; i < temperatureData.length; i++) {
            result += String.format("%.1f", temperatureData[i]) + " ";
        }
        String report =
                "Температуры пациентов: " + result.trim() +
                        "\nСредняя температура: " + getAverageTemperature(temperatureData) +
                        "\nКоличество здоровых: " + getHealthyPatients(temperatureData);

        return report;
    }
}
