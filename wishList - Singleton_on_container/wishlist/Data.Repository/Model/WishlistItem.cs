using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository.Models
{
    class WishlistItem
    {
        public int Code { get; set; }
        public string Name { get; set; }
        public float Price { get; set; }
        public int WishlistItemId { get; set; }
        public Wishlist Wishlist { get; set; }
    }
}
