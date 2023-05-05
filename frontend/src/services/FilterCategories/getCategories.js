const categories = [
  {
    id: 1,
    name: 'place',
    label: 'Alicante',
    value: 'alicante',
  },
  {
    id: 2,
    name: 'place',
    label: 'Valencia',
    value: 'valencia',
  },
  {
    id: 3,
    name: 'place',
    label: 'Madrid',
    value: 'madrid',
  },
  {
    id: 4,
    name: 'date',
    label: 'Anytime',
    value: 'anytime',
  },
  {
    id: 5,
    name: 'date',
    label: 'Last 7 days',
    value: 'last-7d',
  },
  {
    id: 6,
    name: 'date',
    label: 'Last 24 hours',
    value: 'last-24h',
  },
  {
    id: 7,
    name: 'jobCategory',
    label: 'Full stack',
    value: 'fullstack',
  },
  {
    id: 8,
    name: 'jobCategory',
    label: 'Frontend',
    value: 'frontend',
  },
  {
    id: 9,
    name: 'jobCategory',
    label: 'Backend',
    value: 'backend',
  },
  {
    id: 10,
    name: 'jobType',
    label: 'Full remote',
    value: 'remote',
  },
  {
    id: 11,
    name: 'jobType',
    label: 'Hybrid',
    value: 'hybrid',
  },
  {
    id: 12,
    name: 'jobType',
    label: 'Office',
    value: 'office',
  },
  {
    id: 13,
    name: 'requiredStudies',
    label: 'No studies',
    value: 'nothing',
  },
  {
    id: 14,
    name: 'requiredStudies',
    label: 'High School ',
    value: 'high',
  },
  {
    id: 15,
    name: 'requiredStudies',
    label: 'Degree',
    value: 'degree',
  },
  {
    id: 16,
    name: 'requiredExperience',
    label: 'Experience',
    value: 0,
  },
  {
    id: 17,
    name: 'salary',
    label: 'Salary',
    value: 0,
  },
  {
    id: 18,
    name: 'workingHours',
    label: 'Full Time ',
    value: 'fulltime',
  },
  {
    id: 19,
    name: 'workingHours',
    label: 'Part Time ',
    value: 'parttime',
  },
];

const getCategories = (name = '') => {
  if (name !== '') {
    return categories.filter((category) => categories.name === name);
  }
  return categories;
};

export { getCategories };
