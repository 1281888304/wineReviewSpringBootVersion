<html><head><title>hw5 - 3</title></head><body>
  <table border="1">
    <tr>
      <th>CompanyName</th>
      <th>Restaurants</th>
    </tr>
    <xsl:for-each select="Companys/Company">
      <xsl:variable name="companyname" select="CompanyName"></xsl:variable>
      <tr>
        <td>
          <xsl:value-of select="CompanyName"></xsl:value-of>
        </td>
        <td>
          <xsl:value-of select="Restaurants/Restaurant/Name"></xsl:value-of>
        </td>
      </tr>
    </xsl:for-each>
  </table>
</body></html>