<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Add New Family Members</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="f_name"  /></td>  
         </tr>    
         <tr>    
          <td>profession :</td>    
          <td><form:input path="f_profession" /></td>  
         </tr>   
          <tr>    
          <td>Weight :</td>    
          <td><form:input path="f_weight" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>   