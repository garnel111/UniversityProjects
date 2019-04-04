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
    class OwnerContext: DbContext 
    {

        public OwnerContext() : base("Name = ???")
        {

        }
        public DbSet<Owner> Owners { get; set; }
        public DbSet<Wishlist> Wishlist { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new OwnerMap());
            modelBuilder.Configurations.Add(new WishlistMap());
        }
    }
}
