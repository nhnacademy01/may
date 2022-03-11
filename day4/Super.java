//public class Super {
//    public static void main(String[] args) {
//        Car car = new Car();
//        car.speed = 10;
//        System.out.println("speed = "+car.getSpeed());  //부모의 speed인 0 출력
//        System.out.println("vehicleSpeed = " + car.getVehicleSpeed()); //자신 speed인 10출력
//    }
//}
//class Vehicle {
//    int speed;
//    int getSpeed() {
//        return this.speed;   // this.speed
//    }
//}
//class Car extends Vehicle {
//    int speed;
//    int getVehicleSpeed() {
////        return super.speed; // super.speed
//        return this.speed; // this.speed
//    }
//}
//
