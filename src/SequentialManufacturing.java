import java.util.*;

public class SequentialManufacturing {

    static int machines = 0;
    static int produceItem = 0;
    static machine[] machineArray;
    static int inputAreaValue = 0;
    static int inputAreaSize = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        machines = Integer.parseInt(inputArray[0]);
        produceItem = Integer.parseInt(inputArray[1]);

        machineArray = new machine[machines];
        int[] produceTimes = new int[machines];

        String input2 = scanner.nextLine();
        String[] machineTimes = input2.split(" ");
        String input3 = scanner.nextLine();
        String[] inputAreaTimes = input3.split(" ");

        for (int i = 0; i < machines; i++) {
            if (i == 0 ){
                produceTimes[i] = Integer.parseInt(machineTimes[i]);
                machineArray[i] = new machine(i, produceTimes[i], 1000000000, 10000);

            }else {
                produceTimes[i] = Integer.parseInt(machineTimes[i]);
                inputAreaSize = Integer.parseInt(inputAreaTimes[i - 1]);
                machineArray[i] = new machine(i, produceTimes[i],inputAreaSize, inputAreaValue);
            }
        }

        long totalTime = 0;
        long slowestMachine = 0;
        for (int i = 0; i < machines; i++) {
            machine currentMachine = machineArray[i];
            if(currentMachine.getMachineNumber() > 0 && currentMachine.getProcessingTime() >= machineArray[(int) slowestMachine].getProcessingTime()){
                slowestMachine = i;

            }

        }
        long timeTillStart = 0;
        for (int i = 0; i < machines; i++) {
            if (i == slowestMachine){
                continue;
            } else {
                timeTillStart += machineArray[i].getProcessingTime();
            }
        }
        totalTime = machineArray[(int) slowestMachine].getProcessingTime() * produceItem + timeTillStart;
        System.out.println(totalTime);
    }

    static class machine {
        private long machineNumber;
        private long processingTime;
        private long inputAreaSize;
        private long inputAreaValue;
        private long timePlusStart;

        public machine(long machineNumber, long processingTime, long inputAreaSize, long inputAreaValue ) {
            this.machineNumber = machineNumber;
            this.processingTime = processingTime;
            this.inputAreaValue = inputAreaValue;
            this.inputAreaSize = inputAreaSize;
        }

        public void setMachineNumber(long machineNumber) {
            this.machineNumber = machineNumber;
        }

        public void setProcessingTime(long processingTime) {
            this.processingTime = processingTime;
        }

        public void setInputAreaSize(long inputAreaSize) {
            this.inputAreaSize = inputAreaSize;
        }

        public void setInputAreaValue(long inputAreaValue) {
            this.inputAreaValue = inputAreaValue;
        }

        public void setTimePlusStart(long timePlusStart) {
            this.timePlusStart = timePlusStart;
        }

        public long getMachineNumber() {
            return machineNumber;
        }

        public long getProcessingTime() {
            return processingTime;
        }

        public long getInputAreaSize() {
            return inputAreaSize;
        }

        public long getInputAreaValue() {
            return inputAreaValue;
        }

        public long getTimePlusStart() {
            return timePlusStart;
        }
    }
}