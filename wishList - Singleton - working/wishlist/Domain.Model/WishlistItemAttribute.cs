namespace Farfetch.wishlist.Domain.Model
{
   public  class WishlistItemAttribute : AuditableDomainEntity
    {

        public WishlistItemAttribute()
        {

        }
        public int Key { get; set; }
        public int Value { get; set; }
        public int WishlistItemId { get; set; }
        public WishlistItem WishlistItem { get; set; }

        public override bool Equals(object obj)
        {
            return base.Equals(obj);
        }

        public override string ToString()
        {
            return base.ToString();
        }

    }
}
