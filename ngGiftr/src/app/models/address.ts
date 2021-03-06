export class Address {
id: number;
street: string;
street2: string;
city: string;
country: string;
zip: string;
stateProvince: string;
enabled: boolean;

  constructor(
    id?: number,
    street?: string,
    street2?: string,
    city?: string,
    country?: string,
    zip?: string,
    stateProvince?: string,
   enabled?: boolean
  )   {
    this.id = id;
    this.street = street;
    this.street2 = street2;
    this.city = city;
    this.country = country;
    this.zip = zip;
    this.stateProvince = stateProvince;
    this.enabled = enabled;
  }
}

