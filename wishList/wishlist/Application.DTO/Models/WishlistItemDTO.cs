using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
 

namespace Farfetch.wishlist.Application.DTO
{
  public   class WishlistItemDTO
    {
        public int Code { get; set; }
        public string Name { get; set; }
        public float Price { get; set; }
        public int WishlistItemId { get; set; }
        public Wishlist WishList { get; set; }
    }
}
