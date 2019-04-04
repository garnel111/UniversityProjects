using Farfetch.wishlist.Data.Repository.Models.Mapping;
using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository.Models
{
    class WishlistContext: DbContext
    {
        public WishlistContext() : base("Name = ???")
        {

        }

        public DbSet<Wishlist> Wishlist { get; set; }
        public DbSet<WishlistItem> WishlistItem { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
           // modelBuilder.Configurations.Add(new OwnerMap());
            modelBuilder.Configurations.Add(new WishlistMap());
        }
    }
}
