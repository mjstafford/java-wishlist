import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

//model level

@Entity
@Table (name = "products")
public class Product {
  @Id
  @SequenceGenerator(name = "product_generator", sequenceName = "products_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
  @Column(name = "id", nullable = false, unique = true)
  private long id;

  @NotBlank //checks for empty spaces or null values
  @Column(name = "name", nullable = false, length = 50, unique = true)  //unique true here, doesn't stop duplicates
  private String name;

  //model error handling
  @DecimalMin(value = "0.01")
  @NotNull
  @Digits(integer = 8, fraction = 2, message = "price should be to two decimals")
  @Column(name = "price", nullable = false)
  private double price;

  @URL(regexp = "^(http|https).*||null", message = "URL must start with 'http:' or 'https:'")
  @Column(name = "url")
  private String url;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
}