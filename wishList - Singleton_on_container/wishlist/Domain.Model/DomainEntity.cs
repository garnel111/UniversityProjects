namespace Farfetch.wishlist.Domain.Model
{
    public abstract class DomainEntity
    {
       
        public DomainEntity()
        {

        }
       public int ExternalId { get; set; }
    }
}