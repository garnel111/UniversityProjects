using System;
using System.Collections.Generic;

namespace Farfetch.wishlist.Domain.Model
{

    public class WishlistItem : AuditableDomainEntity, IEquatable<WishlistItem>
    {
        public int Code { get; set; }
        public string Name { get; set; }
        public float Price { get; set; }
        public int WishlistItemId { get; set; }
        public Wishlist Wishlist { get; set; }
        public WishlistItem()
        {

        }
        public WishlistItem(int Code, string Name)
        {
            this.Code = Code;
            this.Name = Name;
          //  this.Price = Price;
        }
        public ICollection<WishlistItemAttribute> WishlistItemAttributes { get; set; }

        public bool Equals(WishlistItem other)
        {
            if (other == null)
            {
                return false;
            }

            if (this.WishlistItemId == other.WishlistItemId && this.Name == other.Name && this.Code == other.Code)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public override string ToString()
        {
            System.Console.WriteLine(" Item code: " + Code.ToString() + "\n WishlistItemid: " + WishlistItemId.ToString() + "\n itemName: " + Name.ToString());
            return null;
        }

       
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }

}
