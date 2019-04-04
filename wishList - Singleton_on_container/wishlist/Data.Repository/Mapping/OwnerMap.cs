using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository.Models.Mapping
{
    public class OwnerMap : EntityTypeConfiguration<Owner>
    {
        public OwnerMap()
        {
            // Primary Key
            this.HasKey(t => t.ExternalId);

            // Properties
            this.Property(t => t.Name)
                .HasMaxLength(150);

       

            // Table & Column Mappings
            this.ToTable("Owner", "dbo");
            this.Property(t => t.ExternalId).HasColumnName("ExternalId");
            this.Property(t => t.Name).HasColumnName("Name");
        }
        
       
        
    }
}
