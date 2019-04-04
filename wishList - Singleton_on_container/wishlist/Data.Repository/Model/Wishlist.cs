using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository.Models
{
    class Wishlist
    {

        public int ExternalId { get; set; }
        public int OwnerId { get; set; }
        public List<WishlistItem> Items { get; set; }
        //public wishlist(List<WishlistItem> Items)
        //{
        //    this.Items = new List<WishlistItem>();
        //}


        //public wishlist()
        //{
        //    this.Items = new List<WishlistItem>();
        //}
        //public wishlist(int ExternalId, int OwnerId, List<WishlistItem> Items)
        //{
        //    this.ExternalId = ExternalId;
        //    this.OwnerId = OwnerId;
        //    this.Items = Items;
        //}
    }
}
