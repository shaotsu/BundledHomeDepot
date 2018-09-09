import java.io.*;
import java.util.*;


class Materials
{
 
 Scanner item = new Scanner(System.in);

 private String prodId;
 private String prodDept;
 private String prodSubDept;   //matches to category in SQL code
 private String prodBrand;     //matches to subcategory in SQL code
 private String prodName;
 private double prodPrice;

 //placeholder - empty constructor
 public Materials()  
 {
   this.prodId = "";
   this.prodDept = "";
   this.prodSubDept = "";
   this.prodBrand = "";
   this.prodName = "";
   this.prodPrice = 0;
 }
 
 //full constructor
 public Materials(String pI, String pD, String pSD, String pB, String pN, int pQ, double pP) 
 {
   this.prodId = pI;
   this.prodDept = pD;
   this.prodSubDept = pSD;
   this.prodBrand = pB;
   this.prodName = pN;
   this.prodQuantity = pQ;
   this.prodPrice = pP;
 }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdDept() {
        return prodDept;
    }

    public void setProdDept(String prodDept) {
        this.prodDept = prodDept;
    }

    public String getProdSubDept() {
        return prodSubDept;
    }

    public void setProdSubDept(String prodSubDept) {
        this.prodSubDept = prodSubDept;
    }

    public String getProdBrand() {
        return prodBrand;
    }

    public void setProdBrand(String prodBrand) {
        this.prodBrand = prodBrand;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    /*
 //we add a material to the arraylist
 public String addMaterial()
 {
  while(item.nextLine() != "Done") 
  {
   materialID.add(item.nextLine());
   if(materialID.isEmpty() == true); 
   {
    return "Empty";
    break;
   }
   else 
   {
    System.out.println("Your materials are: "+materialID);
   }
  }
 }
 */

    @java.lang.Override
    public java.lang.String toString() {
        return "Materials:" + '/n'
                "prodId='" + prodId + '\n'' +
                ", prodDept='" + prodDept + '\n'' +
                ", prodSubDept='" + prodSubDept + '\n'' +
                ", prodBrand='" + prodBrand + '\n'' +
                ", prodName='" + prodName + '\n'' +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
