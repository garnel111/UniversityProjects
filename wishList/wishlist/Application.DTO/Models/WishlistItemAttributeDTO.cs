using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Application.DTO
{
   public class WishlistItemAttributeDTO
    {
        public int Key { get; set; }
        public int Value { get; set; }
        public int WishlistItemId { get; set; }
      //  public WishlistItem WishlistItem { get; set; }
    }
}
