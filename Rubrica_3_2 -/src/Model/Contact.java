package Model;


import com.opencsv.bean.CsvBindByPosition;


    public class Contact implements EntityWrapper{
        @CsvBindByPosition(position = 0)
        private String name;
        @CsvBindByPosition(position = 1)
        private String surname;
        @CsvBindByPosition(position = 2)
        private String phoneNumber;


    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }


        public Contact() {

        }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
}