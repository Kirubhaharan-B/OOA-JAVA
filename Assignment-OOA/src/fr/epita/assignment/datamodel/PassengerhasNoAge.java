package fr.epita.assignment.datamodel;

public class PassengerhasNoAge {
        private String name;
        private String passengerClass;
        private String sex;
        private Double age;
        private Boolean survived;

        public PassengerhasNoAge(String name, String passengerClass, String sex, Boolean survived) {
            this.name = name;
            this.passengerClass = passengerClass;
            this.sex = sex;
            this.survived = survived;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassengerClass() {
            return passengerClass;
        }

        public void setPassengerClass(String passengerClass) {
            this.passengerClass = passengerClass;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Boolean getSurvived() {
            return survived;
        }

        public void setSurvived(Boolean survived) {
            this.survived = survived;
        }

        @Override
        public String toString() {
            return "Passenger [name=\"" + this.name + " , survived=\"" + this.survived + "\"]";
        }

    }
