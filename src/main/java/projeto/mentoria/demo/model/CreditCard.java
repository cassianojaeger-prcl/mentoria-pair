package projeto.mentoria.demo.model;

public class CreditCard {
  private Long id;
  private String number;
  private int expirationYear;

  public CreditCard(Long id, String number, int expirationYear) {
    this.id = id;
    this.number = number;
    this.expirationYear = expirationYear;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public int getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(int expirationYear) {
    this.expirationYear = expirationYear;
  }
}
