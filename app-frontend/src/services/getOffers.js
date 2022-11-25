const offers = [
  {
    id: '1',
    title: 'Offer title TEST',
    place: 'Offer place',
    category: 'Offer category',
    type: 'Offer type',
    experience: 'Experience',
    studies: 'Degree',
    salary: 'Salary',
    companyName: 'Company name',
    description:
      'KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds',
  },
  {
    id: '2',
    title: 'Offer title',
    place: 'Offer place',
    category: 'Offer category',
    type: 'Offer type',
    experience: 'Experience',
    studies: 'Degree',
    salary: 'Salary',
    companyName: 'Company name',
    description:
      'KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds',
  },
  {
    id: '3',
    title: 'Offer title',
    place: 'Offer place',
    category: 'Offer category',
    type: 'Offer type',
    experience: 'Experience',
    studies: 'Degree',
    salary: 'Salary',
    companyName: 'Company name',
    description:
      'KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds KAJSDKLJK kajKDJKA dkjadksjk jdkaj kds',
  },
];

const getOffers = (filter = {}) => {
  // crear query con el filtro
  // ejecutar query
  localStorage.setItem('lastSearchedOffers', JSON.stringify(offers));
  // Base de datos
  if (filter.id) {
    return offers.find((offer) => offer.id === filter.id);
  } else if (Object.keys(filter).length === 0) {
    return offers;
  } else {
    return offers;
  }
};

const getLocalOffer = (filter = {}) => {
  const jsonOffers = localStorage.getItem('lastSearchedOffers');
  let localOffers = null;
  let desiredOffer = null;
  if (jsonOffers && filter.id) {
    localOffers = JSON.parse(jsonOffers);
    desiredOffer = localOffers.find((offer) => offer.id === filter.id);

    if (desiredOffer) return desiredOffer;
  }
};

export { getOffers };
