


class Car {

    final int five = 5;
    int yearModel;
    String make;
    int speed;


    public void accelerate() {
        this.speed += five;

    }

    public void brake() {
        if (this.speed >= five) {
            this.speed -= five;
        } else {
            this.speed = 0;

        }


    }


}

