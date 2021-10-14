public class WeightedRepExercise extends RepExercise{

        private double weight;

        public WeightedRepExercise(String name, int sets, int rest, String muscle, int numrep, double weight) {
                super(name, sets, rest, muscle, numrep);
                this.weight = weight;
        }

        public String getWeight() {
                return String.valueOf(weight);
        }
}