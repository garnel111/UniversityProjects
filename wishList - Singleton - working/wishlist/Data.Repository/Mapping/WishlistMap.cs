using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository.Models.Mapping
{
    class WishlistMap : EntityTypeConfiguration<Wishlist>
    {
        public WishlistMap()
        {
            // Primary Key
            this.HasKey(t => t.ExternalId);

            // Properties
            this.Property(t => t.OwnerId);
               



            // Table & Column Mappings
            this.ToTable("Wishlist", "dbo");
            this.Property(t => t.ExternalId).HasColumnName("ExternalId");
            this.Property(t => t.OwnerId).HasColumnName("OwnerId");
        }
    }
}
