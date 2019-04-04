
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository.Models.SqlQueries
{
   public class WishlistQueries
    {
        // join FarROrders r on o.SiteID = r.SiteID and o.OrderID = r.OrderID
       public  static readonly string GetWishlistById = @"select *
        from Wishlist wl
      
        where wl.wishlistId = @wishlistId;";


    }
}
