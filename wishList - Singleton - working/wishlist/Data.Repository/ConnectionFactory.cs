using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository
{
   public  class ConnectionFactory : IConnectionFactory
    {
        //private string connectionString = SiteSettings.ConnectionString;
        private string connectionString = ConfigurationManager.AppSettings["ConnectionString"];
           //@"Data Source=dev-we-vm-obx33.westeurope.cloudapp.azure.com\mssqlserver,14330;Initial Catalog=WishlistDatabase2;Persist Security Info=True; Integrated Security=SSPI; Trusted_Connection=True; Asynchronous Processing=True; Application Name=CustomersMain; ";

        public IDbConnection GetConnection
        {
            get
            {
                var factory = DbProviderFactories.GetFactory("System.Data.SqlClient");
                var connection = factory.CreateConnection();
                connection.ConnectionString = this.connectionString;
                connection.Open();
                return connection;
            }
        }
    }
}
