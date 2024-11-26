package ru.job4j.ood.isp;

public interface ThirdExampleEmployee {
    void getSalary();
    void getVacation();
    void teach();
    void cure();
    void build();
}

class Doctor implements ThirdExampleEmployee {
    @Override
    public void getSalary() {
        System.out.println("Doctor get salary");
    }

    @Override
    public void getVacation() {
        System.out.println("Doctor get vacation");
    }

    @Override
    public void teach() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cure() {
        System.out.println("Doctor cure");
    }

    @Override
    public void build() {
        throw new UnsupportedOperationException();
    }
}
