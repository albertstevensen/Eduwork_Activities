/// <reference types="cypress" />

import{Given, When, Then} from 'cypress-cucumber-preprocessor/steps'

Given('I should open zero bank homepage', () => {
    cy.visit('http://zero.webappsecurity.com/index.html')
})

When('I input data and submit in searchbox', () => {
    cy.get('#searchTerm').type('Zero{enter}')
})

Then('I should have a result search', () => {
    cy.contains('Search Results:')
})
